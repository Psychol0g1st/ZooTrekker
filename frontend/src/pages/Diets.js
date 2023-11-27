import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from '../components/Layout';
import DataTable from '../components/DataTable';
import { deepCopy } from '../utils/deep-copy';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

const Etrendek = () => {
  const [entities, setEntity] = useState([]);
  const [selectedEntity, setSelectedEntity] = useState(null);
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  const formDefinition = { // ures form az adott entitasnak
    id: '',
    substanceId: '',
    amount: '',
    weekdays: '',
    hours: '',
  }
  const [formValues, setFormValues] = useState(deepCopy(formDefinition));
  const dataTableColumns = [
    {
    key: 'id',
    label: 'ID',
    },
    {
      key: 'substance.name',
      label: 'Fogyasztási cikk'
    },
    {
      key: 'amount',
      label: 'Mennyiség',
    },
    {
      key: 'weekdays',
      label: 'Étetési Napok',
    },
    {
      key: 'hours',
      label: 'Étetési Órák',
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
      axios.put(`http://localhost:8082/animaldiets/update/` + formValues.id, formValues)
    } else {
      // Create new entity
      const newEntity = { id: entities.length + 1, ...formValues };
      setEntity([...entities, newEntity]);
      axios.post(`http://localhost:8082/animaldiets/add`, newEntity)
    }
    closeSidebar();
  }
  const handleRowChange = (e) => {
    e.substanceId = e?.substance?.id ? e?.substance?.id : 0;
    setSelectedEntity(e);
    setFormValues(e);
    openSidebar();
  }

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8082/animaldiets/getall');
        setEntity(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);

  return (
    <Layout>
      <div className='d-flex'>
        <h1>Étrend kezelés</h1>
        <button className='ms-auto btn btn-brown icon' onClick={openSidebar}><FontAwesomeIcon icon={faPlus}/></button>
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
                        Fogyasztási cikkek
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="substance"
                      name="substance"
                      value={formValues.substance}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                        Mennyiség
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="amount"
                      name="amount"
                      value={formValues.amount}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                        Étetési Napok
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="weekdays"
                      name="weekdays"
                      value={formValues.weekdays}
                      onChange={handleInputChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label htmlFor="description" className="form-label">
                        Étetési Órák
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="hours"
                      name="hours"
                      value={formValues.hours}
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

export default Etrendek;
