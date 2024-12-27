import axios from 'axios';


export const baseURL="https://bc18-103-31-40-151.ngrok-free.app";
export const httpClient=axios.create({
    baseURL:baseURL,
});