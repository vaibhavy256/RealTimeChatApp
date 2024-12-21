import { use, useContext, useState } from "react";
import { Children, createContext } from "react";
import { ChatProvider }

const ChatContext =createContext();

export const chatProvider=({children}) => {
    const[roomId,setRoomId]=useState("");
    const[currentUser,setCurrentUser]=useState("");
    return(
        <ChatContext.Provider
        value={{roomId,currentUser,setRoomId,setCurrentUser }}
        >
            {children}
        </ChatContext.Provider>
    );
};

const useChatContext = ()=> useContext(ChatContext);
export default useChatContext;

