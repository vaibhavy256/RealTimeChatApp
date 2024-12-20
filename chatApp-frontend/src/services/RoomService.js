import {httpClient} from "../config/AxiosHelper"

export const createRoomAPi=async (roomDetail)=>{
    const response=await httpClient.post(`/api/create`,roomDetail);
    return response.data;
}