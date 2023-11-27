import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from '../components/Layout';
import DataTable from '../components/DataTable';
import { deepCopy } from '../utils/deep-copy';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { SubstanceType } from '../enums/substance-type';

const Substances = () => {
  const [entities, setEntity] = useState([]);
  const [selectedEntity, setSelectedEntity] = useState(null);
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  
  const formDefinition = { 
    type: '',
    name: '',
    unit: '',
    stock: '',
  };
  const [formValues, setFormValues] = useState(deepCopy(formDefinition));
  const dataTableColumns = [
    {
    key: 'id',
    label: 'ID',
    },
    {
      key: 'type',
      label: 'Típus',
    },
    {
      key: 'name',
      label: 'Név',
    },
    {
      key: 'unit',
      label: 'Mértékegység',
    },
    {
      key: 'stock',
      label: 'Készlet',
    }
  ]


  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8082/substances/getall');
        setEntity(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);
  const handleInputChange = (e) => {
      const { name, value } = e.target;
      setFormValues((prevValues) => ({ ...prevValues, [name]: value }));
    };
    const handleRowChange = (e) => {
    setSelectedEntity(e);
    setFormValues(e);
    openSidebar();
  }
  const openSidebar = () => {
    setIsSidebarOpen(true);
  };
  const closeSidebar = () => {
    setIsSidebarOpen(false);
    setFormValues(deepCopy(formDefinition));
  };
  const handleSave = async () => {
    if (selectedEntity) {
      
      const res = await axios.put(`http://localhost:8082/substances/update/` + formValues.id, formValues)
      if(res.status === 200) {
        const updatedEntities = entities.map((entity) =>
          entity.id === selectedEntity.id ? { ...entity, ...res.data } : entity
        );
        setEntity(updatedEntities);
      }
    } else {
      const res = await axios.post(`http://localhost:8082/substances/add`, formValues)
      if(res.status === 200) {
        setEntity([...entities, res.data]);
      }
    }
    closeSidebar();
  }
  const handleDelete = async () => {
    try{
      await axios.delete(`http://localhost:8082/substances/delete/` + selectedEntity.id);
      const updatedEntities = entities.filter((entity) => entity.id !== selectedEntity.id);
      setEntity(updatedEntities);
      closeSidebar();
    }
    catch(error){
      alert('Hiba a törlés során!');
      console.error(error);
    }
  }

  return (
    <Layout>
      <div className='d-flex'>
        <h1>Fogyasztási cikkek</h1>
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
                    <div className='mb-3'>
                        <label htmlFor="type" className="form-label">
                            Típus
                        </label>
                        <select 
                        className="form-select"
                        id="type"
                        name="type"
                        value={formValues.type}
                        onChange={handleInputChange}
                        >
                            {Object.keys(SubstanceType).map((key) => (
                                  <option key={SubstanceType[key]} value={SubstanceType[key]}>
                                      {SubstanceType[key]}
                                  </option>
                              ))}
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="unit" className="form-label">
                            Mértékegység
                        </label>
                        <input
                        type="text"
                        className="form-control"
                        id="unit"
                        name="unit"
                        value={formValues.unit}
                        onChange={handleInputChange}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="stock" className="form-label">
                            Készlet
                        </label>
                        <input
                        type="number"
                        className="form-control"
                        id="stock"
                        name="stock"
                        value={formValues.stock}
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

export default Substances;
