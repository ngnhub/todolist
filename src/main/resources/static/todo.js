document.addEventListener("DOMContentLoaded", function () {
    // Initialize functions on page load
    loadTodos();

    // Attach the submit event to the form
    document.querySelector('#addTodoForm').addEventListener('submit', function (event) {
        event.preventDefault();
        addTodo();
    });
});

// Function to load tasks
function loadTodos() {
    fetch('/api/todo')
        .then(response => response.json())
        .then(todos => {
            const todosContainer = document.getElementById('todo-list');
            todosContainer.innerHTML = ''; // Clean current list
            todos.forEach(todo => {
                const todoItem = document.createElement('div');
                todoItem.classList.add('todo-item');
                todoItem.innerHTML = `
                <p>Title: ${todo.title}</p>
                <p>Description: ${todo.description || ''}</p>
                <p>Status: ${todo.status}</p>
                <p>Deadline: ${todo.completeUntil || ''}</p>
            `;
                todosContainer.appendChild(todoItem);
            });
        })
        .catch(error => console.error('Ошибка:', error));
}

// Function to add a task
function addTodo() {
    const form = document.getElementById('addTodoForm');
    const formData = new FormData(form);

    const todoData = {};
    formData.forEach((value, key) => {
        todoData[key] = value ? value : null;
    });

    // Send data as JSON
    fetch('/api/todo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',  // Send JSON app type
        },
        body: JSON.stringify(todoData)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(newTodo => {
            // Add the new task to the list without reloading the page
            const todosContainer = document.getElementById('todo-list');
            const todoItem = document.createElement('div');
            todoItem.classList.add('todo-item');
            todoItem.innerHTML = `
            <p>Title: ${newTodo.title}</p>
            <p>Description: ${newTodo.description || ''}</p>
            <p>Status: ${newTodo.status}</p>
            <p>Deadline: ${newTodo.completeUntil || ''}</p>
        `;
            todosContainer.appendChild(todoItem);
        })
        .catch(error => console.error('Error:', error));
}
