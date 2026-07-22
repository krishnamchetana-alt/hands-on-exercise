import { useMemo, useState } from 'react';

const initialNotes = [
  { id: 1, title: 'Component thinking', text: 'Break the screen into small, reusable pieces before writing UI code.', tag: 'React', color: 'purple' },
  { id: 2, title: 'State changes the UI', text: 'When state changes, React renders the latest view for the user.', tag: 'State', color: 'orange' },
  { id: 3, title: 'Useful array methods', text: 'Use map to render lists, filter to narrow results, and find for one item.', tag: 'JavaScript', color: 'blue' },
];
const tags = ['All', 'React', 'State', 'JavaScript', 'Personal'];

export default function App() {
  const [notes, setNotes] = useState(initialNotes);
  const [search, setSearch] = useState('');
  const [activeTag, setActiveTag] = useState('All');
  const [draft, setDraft] = useState({ title: '', text: '', tag: 'Personal' });
  const shown = useMemo(() => notes.filter((note) => (activeTag === 'All' || note.tag === activeTag) && `${note.title} ${note.text}`.toLowerCase().includes(search.toLowerCase())), [notes, activeTag, search]);
  function createNote(event) { event.preventDefault(); if (!draft.title.trim() || !draft.text.trim()) return; setNotes((current) => [{ id: Date.now(), ...draft, title: draft.title.trim(), text: draft.text.trim(), color: 'green' }, ...current]); setDraft({ title: '', text: '', tag: 'Personal' }); }
  function deleteNote(id) { setNotes((current) => current.filter((note) => note.id !== id)); }
  return <main className="shell"><aside><div className="brand">◉ <b>notely</b></div><p className="eyebrow">React 3 · Hands-on</p><h1>Keep ideas<br/><em>beautifully</em><br/>simple.</h1><p className="aside-copy">A small notes app to practise forms, filtering, array methods and React state.</p><div className="skills"><b>You will use</b><span>▸ Controlled inputs</span><span>▸ useState</span><span>▸ useMemo</span><span>▸ Conditional UI</span></div></aside><section className="workspace"><header><div><p className="eyebrow">Your workspace</p><h2>My notes <span>{notes.length}</span></h2></div><input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="⌕ Search notes" /></header><nav>{tags.map((tag) => <button key={tag} className={tag === activeTag ? 'active' : ''} onClick={() => setActiveTag(tag)}>{tag}</button>)}</nav><form onSubmit={createNote} className="composer"><input value={draft.title} onChange={(e) => setDraft({ ...draft, title: e.target.value })} placeholder="Note title"/><textarea value={draft.text} onChange={(e) => setDraft({ ...draft, text: e.target.value })} placeholder="Write a quick thought…"/><div><select value={draft.tag} onChange={(e) => setDraft({ ...draft, tag: e.target.value })}>{tags.slice(1).map((tag) => <option key={tag}>{tag}</option>)}</select><button type="submit">+ Add note</button></div></form><div className="note-grid">{shown.map((note) => <article key={note.id} className={`note ${note.color}`}><div><span>{note.tag}</span><button onClick={() => deleteNote(note.id)} aria-label={`Delete ${note.title}`}>×</button></div><h3>{note.title}</h3><p>{note.text}</p><small>Just now</small></article>)}{!shown.length && <p className="no-results">No matching notes. Try another filter or add one.</p>}</div></section></main>;
}
