import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from '../components/Layout';
import DataTable from '../components/DataTable';

const Substances = () => {
  const [substances, setSubstances] = useState([]);
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

  const formDefinition = {}


  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8082/substances/getall');
        setSubstances(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, []);

  return (
    <Layout>
      <h1>Fogyasztási cikkek</h1>
      <DataTable data={substances} columns={dataTableColumns} formDefinition={formDefinition}/>
    </Layout>
  );
};

export default Substances;
