import {httpClient} from "../config/AxiosHelper"

export const createRoomAPi = async (roomId, userName) => {
    const response = await httpClient.post(`/api/create/${roomId}/${userName}`);
    return response.data;
};

