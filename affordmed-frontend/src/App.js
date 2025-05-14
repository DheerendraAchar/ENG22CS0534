import React, { useState } from 'react';
import AveragePriceForm from '/Users/admin/Downloads/stockservice/affordmed-frontend/src/components/AveragePrizeform.js';
import CorrelationForm from './components/CorrelationForm';
import ResultDisplay from './components/ResultDisplay';

function App() {
  const [result, setResult] = useState(null);

  return (
    <div className="App">
      <h1>AffordMed Stock Analytics</h1>
      <AveragePriceForm onResult={setResult} />
      <CorrelationForm onResult={setResult} />
      <ResultDisplay result={result} />
    </div>
  );
}

export default App;
