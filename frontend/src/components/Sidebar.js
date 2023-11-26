import {ReactComponent as Logo} from '../icons/LOGO.svg'


export default function Sidebar() {
    const handleLogout = () => {
        localStorage.removeItem('user');
        window.location.href = '/login';
    };
    return(
        <ul className="nav flex-column ">
            <a className="nav-brand" href="/"><Logo/></a>
            <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="/employees">
                    <button type="button" className="btn btn-secondary">Dolgozók</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/animals">
                    <button type="button" className="btn btn-secondary">Állatok</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/cages">
                    <button type="button" className="btn btn-secondary">Ketrecek</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/species">
                    <button type="button" className="btn btn-secondary">Állatfajok</button>
                </a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="/animaldiets">
                    <button type="button" className="btn btn-secondary">Étrend kezelés</button>
                </a>
            </li>
            <li className="nav-item">
                <div className="nav-link">
                    <button type="button" onClick={handleLogout} className="btn btn-secondary">Kijelentkezés</button>
                </div>
            </li>
        </ul>
    )
}