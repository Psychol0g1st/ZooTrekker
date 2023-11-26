import React from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';


const DataTable = ({ data, columns, onRowEvent }) => {
  const handleRowClick = (entity) => {
    onRowEvent(entity);
    
  };
    if (!data || data.length === 0) {
    return <p>No data available.</p>;
  }


  // Assuming the data array has objects with consistent keys

  return (
    <div className="table-responsive">
        <div style={{ overflowX: 'auto' }}>
            <table className="table table-striped">
                <thead>
                    <tr>
                    {columns.map((column) => (
                        <th key={column?.key}>{column.label}</th>
                    ))}
                    </tr>
                </thead>
                <tbody>
                    {data.map((row, rowIndex) => (
                    <tr key={rowIndex} onClick={() => handleRowClick(row)}>
                        {columns.map((column, columnIndex) => (
                        <td key={columnIndex}>
                            {typeof row[column.key] === 'object'
                            ? JSON.stringify(row[column.key])
                            : row[column.key]}
                        </td>
                        ))}
                    </tr>
                    ))}
                </tbody>
            </table>
        </div>
    </div>
  );
};

export default DataTable;
