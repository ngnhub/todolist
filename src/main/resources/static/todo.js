document.addEventListener("DOMContentLoaded", function () {
    // Initialize functions on page load
    loadTodos();

    document.querySelector('#addTodoForm').addEventListener('submit', function (event) {
        event.preventDefault();
        addTodo();
    });
});

function createTodoElement(todo) {
    const todoItem = document.createElement('div');
    todoItem.classList.add('todo-item');

    const titleDiv = document.createElement('div');
    titleDiv.classList.add('title');
    titleDiv.textContent = `${todo.title}`;

    const detailsDiv = document.createElement('div');
    detailsDiv.classList.add('details');

    let detailsHTML = '';

    if (todo.description) {
        detailsHTML += `<p>Description: ${todo.description}</p>`;
    }

    if (todo.status) {
        detailsHTML += `<p>Status: ${todo.status}</p>`;
    }

    if (todo.completeUntil) {
        const isoDate = new Date(todo.completeUntil);
        const localDate = isoDate.toLocaleString();
        detailsHTML += `<p>Deadline: ${localDate}</p>`;
    }

    if (todo.remindAt) {
        const isoDate = new Date(todo.remindAt);
        const localDate = isoDate.toLocaleString();
        detailsHTML += `<p>Reminded for: ${localDate}</p>`;
    }

    // Устанавливаем HTML для detailsDiv
    detailsDiv.innerHTML = detailsHTML;
    let isDetailsVisible = false;
    todoItem.addEventListener('click', function (event) {
        if (isDetailsVisible) {
            detailsDiv.style.display = 'none';
        } else {
            detailsDiv.style.display = 'block';
        }
        isDetailsVisible = !isDetailsVisible;
        event.preventDefault(); // Предотвратить действия по умолчанию
    });

    const deleteIcon = document.createElement('div');
    deleteIcon.classList.add('delete-icon');
    deleteIcon.innerHTML = '&#128465;'; // trash symbol code

    deleteIcon.addEventListener('click', function (event) {
        event.stopPropagation();
        deleteTodo(todo.id);
        todoItem.remove();
    });

    todoItem.appendChild(titleDiv);
    todoItem.appendChild(detailsDiv);
    todoItem.appendChild(deleteIcon);

    return todoItem;
}

function deleteTodo(todoId) {
    fetch(`/api/todo/${todoId}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.ok) {
                const todoItem = document.querySelector(`[data-todo-id="${todoId}"]`);
                if (todoItem) {
                    todoItem.remove();
                }
            } else {
                throw new Error('Network response was not ok.');
            }
        })
        .catch(error => console.error('Error:', error));
}

function loadTodos() {
    fetch('/api/todo')
        .then(response => response.json())
        .then(todos => {
            const todosContainer = document.getElementById('todo-list');
            todosContainer.innerHTML = '';
            todos.forEach(todo => {
                const todoElement = createTodoElement(todo);
                todoElement.dataset.todoId = todo.id;
                todosContainer.appendChild(todoElement);
            });
        })
        .catch(error => console.error('Error:', error));
}

function addTodo() {
    const form = document.getElementById('addTodoForm');
    const formData = new FormData(form);

    const todoData = {};
    formData.forEach((value, key) => {
        // from local date time to iso
        if (key === 'completeUntil' || key === 'remindAt') {
            todoData[key] = value ? new Date(value).toISOString() : null;
        } else {
            todoData[key] = value ? value : null;
        }
    });

    fetch('/api/todo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
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
            const todosContainer = document.getElementById('todo-list');
            todosContainer.appendChild(createTodoElement(newTodo));
        })
        .catch(error => console.error('Error:', error));
}
