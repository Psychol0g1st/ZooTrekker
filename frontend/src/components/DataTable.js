import React, { useEffect } from 'react';

const DataTable = ({ data, columns, onRowEvent }) => {

  const handleRowClick = (entity) => {
    onRowEvent(entity);
  };

  const renderCellValue = (row, key) => {
    const keys = key.split('.');

    // Recursively traverse the nested keys
    const value = keys.reduce((acc, currentKey) => {
      if (acc && typeof acc === 'object') {
        return acc[currentKey];
      }
      return undefined;
    }, row);
    
    const res = typeof value === 'object' ? JSON.stringify(value) : value
    return res;
  };

  if (!data || data.length === 0) {
    return <p>No data available.</p>;
  }

  return (
    <div className="flex-grow-1" style={{ position: 'relative' }}>
      <div style={{ overflowX: 'auto', position: 'absolute', top: 0, left: 0, right: 0, bottom: 0 }}>
        <table className="table table-hover border">
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
                    {renderCellValue(row, column.key)}
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
