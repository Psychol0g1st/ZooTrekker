import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from '../components/Layout';
import DataTable from '../components/DataTable';
import { deepCopy } from '../utils/deep-copy';

const Allatok = () => {
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
      key: 'species',
      label: 'Faj',
    },
    {
      key: 'name',
      label: 'Név',
    },
    {
      key: 'gender',
      label: 'Nem',
    },
    {
      key: 'climate',
      label: 'Éghajlat',
    },
    {
      key: 'cage.name',
      label: 'Ketrec',
    },
    {
      key: 'dateOfBirth',
      label: 'Születési dátum',
    },
    {
      key: 'dateOfArrival',
      label: 'Érkezésési dátum',
    },
    {
      key: 'healthRecords',
      label: 'Egészségügyi nyilvántartások',
    }
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
      axios.put(`http://localhost:8082/animals/update/` + formValues.id, formValues)
    } else {
      // Create new entity
      const newEntity = { id: entities.length + 1, ...formValues };
      setEntity([...entities, newEntity]);
      axios.post(`http://localhost:8082/animals/add`, newEntity)
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
        const response = await axios.get('http://localhost:8082/animals/getall');
        setEntity(response.data);
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
        <h1>Állatok</h1>
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
                    <label htmlFor="description" className="form-label">
                      Faj
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="species"
                      name="species"
                      value={formValues.species}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="name" className="form-label">
                      Név
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="name"
                      name="name"
                      value={formValues.name}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="value" className="form-label">
                      Nem
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="gender"
                      name="gender"
                      value={formValues.gender}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                      Éghajlat
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="climate"
                      name="climate"
                      value={formValues.climate}
                      onChange={handleInputChange}
                    />
                  </div>
                  {/* TODO
                   <div className="mb-3">
                    <label htmlFor="" className="form-label">
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
                  </div>  */}
                  <div className="mb-3">
                    <label htmlFor="date" className="form-label">
                      Születési dátum
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="dateOfBirth"
                      name="dateOfBirth"
                      value={formValues.dateOfBirth}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="date" className="form-label">
                      Érkezésési dátum
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="dateOfArrival"
                      name="dateOfArrival"
                      value={formValues.dateOfArrival}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="fing" className="form-label">
                      Egészségügyi nyilvántartások
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="healthRecords"
                      name="healthRecords"
                      value={formValues.healthRecords}
                      onChange={handleInputChange}
                    />
                  </div>
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

export default Allatok;
