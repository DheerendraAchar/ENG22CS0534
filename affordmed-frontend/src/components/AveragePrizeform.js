import React, { useState } from 'react';
import API from '../services/api';

const AveragePriceForm = ({ onResult }) => {
  const [symbol, setSymbol] = useState('');
  const [minutes, setMinutes] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await API.get(`/stocks/${symbol}?minutes=${minutes}&aggregation=average`);
      onResult(res.data);
    } catch (err) {
      onResult({ error: err.response?.data?.message || 'Request failed' });
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Average Stock Price</h3>
      <input placeholder="Stock Symbol" value={symbol} onChange={(e) => setSymbol(e.target.value)} required />
      <input placeholder="Minutes" type="number" value={minutes} onChange={(e) => setMinutes(e.target.value)} required />
      <button type="submit">Get Average</button>
    </form>
  );
};

export default AveragePriceForm;
