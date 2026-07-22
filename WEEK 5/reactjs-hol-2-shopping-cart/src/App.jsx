import { useMemo, useState } from 'react';

const catalog = [
  { id: 1, name: 'Wireless Headphones', type: 'Audio', price: 2499, icon: '🎧', color: '#fee6d6' },
  { id: 2, name: 'Smart Watch', type: 'Wearables', price: 3999, icon: '⌚', color: '#dceeff' },
  { id: 3, name: 'Desk Lamp', type: 'Home office', price: 1299, icon: '💡', color: '#fff4bf' },
  { id: 4, name: 'Travel Bottle', type: 'Lifestyle', price: 699, icon: '🧴', color: '#d9f6ed' },
];

const money = (value) => new Intl.NumberFormat('en-IN', { style: 'currency', currency: 'INR', maximumFractionDigits: 0 }).format(value);

export default function App() {
  const [cart, setCart] = useState([]);
  const [notice, setNotice] = useState('Choose an item to start your cart.');
  const total = useMemo(() => cart.reduce((sum, item) => sum + item.price * item.quantity, 0), [cart]);
  const count = cart.reduce((sum, item) => sum + item.quantity, 0);

  function add(product) {
    setCart((items) => {
      const found = items.find((item) => item.id === product.id);
      return found ? items.map((item) => item.id === product.id ? { ...item, quantity: item.quantity + 1 } : item) : [...items, { ...product, quantity: 1 }];
    });
    setNotice(`${product.name} added to your cart.`);
  }
  function adjust(id, change) { setCart((items) => items.flatMap((item) => item.id !== id ? item : item.quantity + change > 0 ? [{ ...item, quantity: item.quantity + change }] : [])); }

  return <main>
    <header><div><span className="eyebrow">React 2 · ReactJS-HOL</span><h1>Cart<span>Craft</span></h1></div><div className="cart-count">🛍️ {count} {count === 1 ? 'item' : 'items'}</div></header>
    <section className="intro"><div><p className="eyebrow">Hands-on project</p><h2>Build a cart with <em>React state.</em></h2><p>Explore reusable components, props, list rendering and state updates in a small shopping experience.</p></div><div className="lesson"><b>What you practise</b><span>✓ useState</span><span>✓ Array methods</span><span>✓ Event handlers</span></div></section>
    <div className="layout"><section><div className="section-title"><h2>Featured products</h2><span>{catalog.length} products</span></div><div className="products">{catalog.map((product) => <article className="product" key={product.id}><div className="product-icon" style={{ background: product.color }}>{product.icon}</div><small>{product.type}</small><h3>{product.name}</h3><div className="product-bottom"><b>{money(product.price)}</b><button onClick={() => add(product)}>Add +</button></div></article>)}</div></section>
      <aside><div className="section-title"><h2>Your cart</h2><span>{count} items</span></div><p className="notice">{notice}</p>{cart.length === 0 ? <div className="empty">Your cart is empty.<br/>Add something you love.</div> : <>{cart.map((item) => <div className="cart-item" key={item.id}><span>{item.icon}</span><div><b>{item.name}</b><small>{money(item.price)}</small></div><div className="quantity"><button onClick={() => adjust(item.id, -1)}>−</button><b>{item.quantity}</b><button onClick={() => adjust(item.id, 1)}>+</button></div></div>)}<div className="total"><span>Total</span><b>{money(total)}</b></div><button className="checkout" onClick={() => setNotice('Great work — checkout complete!')}>Checkout</button></>}</aside></div>
  </main>;
}
