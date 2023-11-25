import Dropdown from 'react-bootstrap/Dropdown';
import React from "react";
import axios from 'axios'


export default function DropDown() {
  const [menu, setMenu] = React.useState([]);

    React.useEffect(() => {
        loadMenu()
    }, [])

    const loadMenu = async () => {
      const result = await axios.get(`http://localhost:8082/employees/getall`)
      setMenu(result.data)
    }

  return (
    <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        Employees
      </Dropdown.Toggle>
        
      <Dropdown.Menu>
        {
          menu.map((xd, index) => (
            <Dropdown.Item>{xd.firstName}</Dropdown.Item>
          ))
        }
      </Dropdown.Menu>
    </Dropdown>
  );
}