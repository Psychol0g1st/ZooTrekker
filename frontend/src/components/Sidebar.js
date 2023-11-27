import logo from '../icons/LOGO.svg'


export default function Sidebar() {
    const handleLogout = () => {
        localStorage.removeItem('user');
        window.location.href = '/login';
    };
    return(
        <ul className="nav flex-column align-items-start border bg-light">
            <a className="nav-brand" style={{height: '56px'}} href="/">
                <img src={logo} alt="logo" style={{height: '56px'}}/>
            </a>
            <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="/employees">
                    <button type="button" className="btn btn-brown">Dolgozók</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/animals">
                    <button type="button" className="btn btn-brown">Állatok</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/cages">
                    <button type="button" className="btn btn-brown">Ketrecek</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/species">
                    <button type="button" className="btn btn-brown">Állatfajok</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/climates">
                    <button type="button" className="btn btn-brown">Éghajlatok</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/animaldiets">
                    <button type="button" className="btn btn-brown">Étrend kezelés</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/substances">
                    <button type="button" className="btn btn-brown">Fogyasztási cikkek</button>
                </a>
            </li>
            <li className="nav-item">
                <div className="nav-link">
                    <button type="button" onClick={handleLogout} className="btn btn-brown">Kijelentkezés</button>
                </div>
            </li>
        </ul>
    )
}