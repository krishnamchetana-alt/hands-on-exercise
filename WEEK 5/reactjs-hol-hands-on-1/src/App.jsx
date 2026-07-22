import { useMemo, useState } from 'react';

const starterTasks = [
  { id: 1, title: 'Create the Vite project', category: 'Setup', done: true },
  { id: 2, title: 'Build reusable components', category: 'Components', done: true },
  { id: 3, title: 'Practice React state', category: 'State', done: false },
  { id: 4, title: 'Submit the hands-on project', category: 'Finish', done: false },
];

export default function App() {
  const [tasks, setTasks] = useState(starterTasks);
  const [title, setTitle] = useState('');
  const [filter, setFilter] = useState('all');

  const visibleTasks = useMemo(() => tasks.filter((task) => (
    filter === 'all' || (filter === 'active' ? !task.done : task.done)
  )), [tasks, filter]);

  const completed = tasks.filter((task) => task.done).length;
  const progress = tasks.length ? Math.round((completed / tasks.length) * 100) : 0;

  function addTask(event) {
    event.preventDefault();
    const trimmedTitle = title.trim();
    if (!trimmedTitle) return;
    setTasks((current) => [...current, {
      id: Date.now(), title: trimmedTitle, category: 'Practice', done: false,
    }]);
    setTitle('');
  }

  function toggleTask(id) {
    setTasks((current) => current.map((task) => (
      task.id === id ? { ...task, done: !task.done } : task
    )));
  }

  function removeTask(id) {
    setTasks((current) => current.filter((task) => task.id !== id));
  }

  return (
    <main className="app-shell">
      <section className="hero">
        <span className="eyebrow">React 1 · ReactJS-HOL</span>
        <h1>Learn React by building.</h1>
        <p>A polished hands-on task tracker built with functional components, props, events, state, and derived data.</p>
      </section>

      <section className="dashboard" aria-label="React hands-on task tracker">
        <div className="progress-card">
          <div>
            <p className="label">YOUR PROGRESS</p>
            <h2>{completed} of {tasks.length} exercises complete</h2>
          </div>
          <strong>{progress}%</strong>
          <div className="progress-track" aria-label={`${progress}% complete`}>
            <div className="progress-fill" style={{ width: `${progress}%` }} />
          </div>
        </div>

        <form className="add-task" onSubmit={addTask}>
          <label htmlFor="task-title">Add a practice task</label>
          <div>
            <input id="task-title" value={title} onChange={(event) => setTitle(event.target.value)} placeholder="e.g. Add a new component" />
            <button type="submit">Add task</button>
          </div>
        </form>

        <div className="filters" role="group" aria-label="Filter tasks">
          {['all', 'active', 'done'].map((item) => (
            <button key={item} type="button" className={filter === item ? 'selected' : ''} onClick={() => setFilter(item)}>
              {item === 'all' ? 'All tasks' : item === 'active' ? 'To do' : 'Completed'}
            </button>
          ))}
        </div>

        <ul className="task-list">
          {visibleTasks.map((task) => (
            <li key={task.id} className={task.done ? 'done' : ''}>
              <button className="check" onClick={() => toggleTask(task.id)} aria-label={`Mark ${task.title} as ${task.done ? 'incomplete' : 'complete'}`}>
                {task.done ? '✓' : ''}
              </button>
              <div className="task-copy"><span>{task.category}</span><h3>{task.title}</h3></div>
              <button className="remove" onClick={() => removeTask(task.id)} aria-label={`Remove ${task.title}`}>×</button>
            </li>
          ))}
          {!visibleTasks.length && <li className="empty">No tasks in this view yet.</li>}
        </ul>
      </section>
    </main>
  );
}
