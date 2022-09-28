import Navbar from "./Navbar";

import './styles.css'

const Admin = () => {

    return (
        <div className="admin-contanier">
            <Navbar />
            <div className="admin-content">
                <h1>Conteúdo admin</h1>
            </div>

        </div>
    );
}

export default Admin;