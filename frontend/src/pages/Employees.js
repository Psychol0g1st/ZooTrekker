import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from '../components/Layout';
import DataTable from '../components/DataTable';
import { deepCopy } from '../utils/deep-copy';

const Dolgozok = () => {
  const [entities, setEntity] = useState([]);
  const [selectedEntity, setSelectedEntity] = useState(null);
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  const formDefinition = { // ures form az adott entitasnak
    id: '',
    firstName: '',
    lastName: '',
  }
  const [formValues, setFormValues] = useState(deepCopy(formDefinition));
  const dataTableColumns = [
    {
    key: 'id',
    label: 'ID',
    },
    {
      key: 'lastName',
      label: 'Vezetéknév'
    },
    {
      key: 'firstName',
      label: 'Keresztnév',
    },
    {
      key: 'role',
      label: 'Munkakör',
    },
    {
      key: 'position',
      label: 'Pozíció',
    },
    {
      key: 'salary',
      label: 'Fizetés (Ft)',
    },
    {
      key: 'workDays',
      label: 'Munka napok',
    },
    {
      key: 'workStartHour',
      label: 'Munka kezdete',
    },
    {
      key: 'workEndHour',
      label: 'Munka vége',
    },
    {
      key: 'cage.name',
      label: 'Ketrec',
    },
  ]
  
  const openSidebar = () => {
    setIsSidebarOpen(true);
  };
  const closeSidebar = () => {
    setIsSidebarOpen(false);
    setFormValues(deepCopy(formDefinition));
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormValues((prevValues) => ({ ...prevValues, [name]: value }));
  };

  const handleSave = () => {
    if (selectedEntity) {
      const updatedEntities = entities.map((entity) =>
        entity.id === selectedEntity.id ? { ...entity, ...formValues } : entity
      );
      setEntity(updatedEntities);
      axios.put(`http://localhost:8082/employees/update/` + formValues.id, formValues)
    } else {
      // Create new entity
      const newEntity = { id: entities.length + 1, ...formValues };
      setEntity([...entities, newEntity]);
      axios.post(`http://localhost:8082/employees/add`, newEntity)
    }
    closeSidebar();
  }
  const handleRowChange = (e) => {
    setSelectedEntity(e);
    setFormValues(e);
    openSidebar();
  }

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8082/employees/getall');
        setEntity(response.data);
        console.log(response.data)
      } catch (error) {
        console.error(error);
      }
    };
    console.log("fetch data")
    fetchData();
  }, []);

  return (
    <Layout>
      <div className='d-flex'>
        <h1>Dolgozók</h1>
        <button className='ms-auto btn btn-primary' onClick={openSidebar}>Új</button>
      </div>
      <div className="container-fluid flex-grow-1 d-flex">
        <div className="col flex-grow-1 d-flex">
            <DataTable data={entities} columns={dataTableColumns} onRowEvent={handleRowChange}/>
        </div>
        {isSidebarOpen && (
          <div className="ms-3 col-4">
            <div className="card">
              <div className="card-header">
                {selectedEntity ? 'Edit Entity' : 'Create New Entity'}
                <button
                  type="button"
                  className="btn-close float-end"
                  aria-label="Close"
                  onClick={closeSidebar}
                ></button>
              </div>
              <div className="card-body">
                <form>
                  <div className="mb-3">
                    <label htmlFor="name" className="form-label">
                      Keresztnév
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="firstName"
                      name="firstName"
                      value={formValues.firstName}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                      Vezetéknév
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="lastName"
                      name="lastName"
                      value={formValues.lastName}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                      Munkakör
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="role"
                      name="role"
                      value={formValues.role}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                      Pozíció
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="position"
                      name="position"
                      value={formValues.position}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="value" className="form-label">
                      Fizetés (Ft)
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="salary"
                      name="salary"
                      value={formValues.salary}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                      Munka napok
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="workDays"
                      name="workDays"
                      value={formValues.workDays}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="value" className="form-label">
                      Munka kezdete
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="workStartHour"
                      name="workStartHour"
                      value={formValues.workStartHour}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="value" className="form-label">
                      Munka vége
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="workEndHour"
                      name="workEndHour"
                      value={formValues.workEndHour}
                      onChange={handleInputChange}
                    />
                  </div>
                  {/* <div className="mb-3">
                    <label htmlFor="value" className="form-label">
                      Ketrec
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="cage.name"
                      name="cage.name"
                      value={formValues.cage.name}
                      onChange={handleInputChange}
                    />
                  </div> */}
                  <button
                    type="button"
                    className="btn btn-primary"
                    onClick={handleSave}
                  >
                    Save
                  </button>
                </form>
              </div>
            </div>
          </div>
        )}
      </div>
    </Layout>
  );
};

export default Dolgozok;