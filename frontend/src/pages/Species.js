import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from '../components/Layout';
import DataTable from '../components/DataTable';
import { deepCopy } from '../utils/deep-copy';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

const Allatfajok = () => {
  const [entities, setEntity] = useState([]);
  const [selectedEntity, setSelectedEntity] = useState(null);
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  const formDefinition = { // ures form az adott entitasnak
    name: '',
  }
  const [formValues, setFormValues] = useState(deepCopy(formDefinition));
  const dataTableColumns = [
    {
    key: 'id',
    label: 'ID',
    },
    {
    key: 'name',
    label: 'Faj megnevezése',
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

  const handleSave = async () => {
    if (selectedEntity) {
      const res = await axios.put(`http://localhost:8082/species/update/` + formValues.id, formValues)
      if(res.status === 200) {
        const updatedEntities = entities.map((entity) =>
          entity.id === selectedEntity.id ? { ...entity, ...res.data } : entity
        );
        setEntity(updatedEntities);
      }
    } else {
      const res = await axios.post(`http://localhost:8082/species/add`, formValues)
      if(res.status === 200) {
        setEntity([...entities, res.data]);
      }
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
        const response = await axios.get('http://localhost:8082/species/getall');
        setEntity(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);

  const handleDelete = async (e) => {
    try{
      const res = await axios.delete(`http://localhost:8082/species/delete/` + e.id);
      if(res.status === 200) {
        const updatedEntities = entities.filter((entity) => entity.id !== e.id);
        setEntity(updatedEntities);
      }
    } catch (error) {
      alert('Nem lehet törölni, mivel hozzá van rendelve állatokhoz!');
      console.error(error);
    }
  }

  return (
    <Layout>
      <div className='d-flex'>
        <h1>Állatfajok</h1>
        <button className='ms-auto btn btn-primary icon' onClick={openSidebar}><FontAwesomeIcon icon={faPlus}/></button>
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
                  <div className='d-flex'>
                    <button
                      type="button"
                      className="btn btn-primary"
                      onClick={handleSave}
                    >
                      Save
                    </button>
                    {selectedEntity && (
                      <button
                        type="button"
                        className="btn btn-danger ms-auto"
                        onClick={handleDelete}
                      >
                        Delete
                      </button>
                    )}
                  </div>
                </form>
              </div>
            </div>
          </div>
        )}
      </div>
    </Layout>
  );
};

export default Allatfajok;
