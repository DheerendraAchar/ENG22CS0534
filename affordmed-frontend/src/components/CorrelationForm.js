import React, { useState } from 'react';
import API from '../services/api';

const CorrelationForm = ({ onResult }) => {
  const [symbol1, setSymbol1] = useState('');
  const [symbol2, setSymbol2] = useState('');
  const [minutes, setMinutes] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await API.get(`/stocks/correlation?symbol1=${symbol1}&symbol2=${symbol2}&minutes=${minutes}`);
      onResult(res.data);
    } catch (err) {
      onResult({ error: err.response?.data?.message || 'Request failed' });
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Correlation Between Two Stocks</h3>
      <input placeholder="Symbol 1" value={symbol1} onChange={(e) => setSymbol1(e.target.value)} required />
      <input placeholder="Symbol 2" value={symbol2} onChange={(e) => setSymbol2(e.target.value)} required />
      <input placeholder="Minutes" type="number" value={minutes} onChange={(e) => setMinutes(e.target.value)} required />
      <button type="submit">Get Correlation</button>
    </form>
  );
};

export default CorrelationForm;
