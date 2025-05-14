import React from 'react';

const ResultDisplay = ({ result }) => {
  if (!result) return null;
  return (
    <div>
      <h4>Result:</h4>
      <pre>{JSON.stringify(result, null, 2)}</pre>
    </div>
  );
};

export default ResultDisplay;
