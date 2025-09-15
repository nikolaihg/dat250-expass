<script lang="ts">
  let question = $state("");
  let options = $state<string[]>(["", ""]);
  let createdByUserId = $state<number | null>(null);
  let validUntil = $state<string>("");

  function addOption() {
    options.push("");
  }

  function removeOption(index: number) {
    if (options.length > 2) {
      options.splice(index, 1);
    }
  }

  async function submit() {
    if (!question || options.some(o => !o.trim()) || !createdByUserId) {
      alert("Please fill in all fields including user ID");
      return;
    }

    try {
      const pollPayload = {
        question,
        publishedAt: null,
        validUntil: validUntil ? new Date(validUntil).toISOString() : null,
        createdByUserId
      };

      const pollRes = await fetch("/api/polls", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(pollPayload)
      });

      if (!pollRes.ok) {
        alert("Failed to create poll");
        return;
      }

      const createdPoll = await pollRes.json();
      const pollId = createdPoll.id;

      for (let i = 0; i < options.length; i++) {
        const optionPayload = {
          caption: options[i].trim(),
          presentationOrder: i
        };

        const optionRes = await fetch(`/api/polls/${pollId}/options`, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(optionPayload)
        });

        if (!optionRes.ok) {
          alert(`Failed to create option: ${options[i]}`);
          return;
        }
      }

      alert("Poll created successfully!");
      
      question = "";
      options = ["", ""];
      createdByUserId = null;
      validUntil = "";
      
    } catch (error) {
      console.error("Error creating poll:", error);
      alert("Failed to create poll");
    }
  }
</script>

<div class="create-poll">
  <h2>Create Poll</h2>
  
  <div class="form-group">
    <label for="userId">Your User ID:</label>
    <input 
      id="userId"
      type="number" 
      placeholder="User ID" 
      bind:value={createdByUserId} 
    />
  </div>

  <div class="form-group">
    <label for="question">Question:</label>
    <input 
      id="question"
      placeholder="Enter your poll question" 
      bind:value={question} 
    />
  </div>

  <div class="form-group">
    <label for="validUntil">Expires (optional):</label>
    <input 
      id="validUntil"
      type="datetime-local" 
      bind:value={validUntil} 
    />
  </div>

  <div class="options-section">
    <h3>Options:</h3>
    {#each options as option, i}
      <div class="option-row">
        <input 
          placeholder="Option {i + 1}" 
          bind:value={options[i]} 
        />
        {#if options.length > 2}
          <button 
            type="button" 
            class="remove-btn"
            onclick={() => removeOption(i)}
          >
            Remove
          </button>
        {/if}
      </div>
    {/each}
  </div>

  <div class="actions">
    <button type="button" onclick={addOption}>+ Add Option</button>
    <button type="button" onclick={submit} class="primary">Create Poll</button>
  </div>
</div>

<style>
  .create-poll {
    max-width: 600px;
    margin: 0 auto;
    padding: 1rem;
  }

  .form-group {
    margin-bottom: 1rem;
  }

  .form-group label {
    display: block;
    margin-bottom: 0.5rem;
    font-weight: bold;
  }

  .form-group input {
    width: 100%;
    padding: 0.5rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 1rem;
  }

  .options-section {
    margin-bottom: 1rem;
  }

  .option-row {
    display: flex;
    gap: 0.5rem;
    margin-bottom: 0.5rem;
    align-items: center;
  }

  .option-row input {
    flex: 1;
    padding: 0.5rem;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  .remove-btn {
    padding: 0.5rem 1rem;
    background-color: #dc3545;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  .remove-btn:hover {
    background-color: #c82333;
  }

  .actions {
    display: flex;
    gap: 1rem;
  }

  .actions button {
    padding: 0.75rem 1.5rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1rem;
  }

  .actions button:hover {
    background-color: #f8f9fa;
  }

  .actions button.primary {
    background-color: #007bff;
    color: white;
    border-color: #007bff;
  }

  .actions button.primary:hover {
    background-color: #0056b3;
  }
</style>