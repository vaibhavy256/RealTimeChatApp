import React, { useEffect, useRef, useState } from "react";
import { IoSend } from "react-icons/io5";
import { FaFileUpload } from "react-icons/fa";



const ChatPage = () => {
    const [messages, setMessages]=useState([
        {
            content: "Hello",
            sender:"vaibhav"
        },
        {
            content: "Hello",
            sender:"vaibhav y"
        }
    
    ]);
    const [input,setInput]=useState("");
    const inputRef=useRef(null)
    const chatBoxRef=useRef(null)
    const [stompClient, setStompClient]=useState(null);
    const [roomId,setRoomId]=useState("");
    const [currentUser]=useState("vaibhav")
  return (
  <div className=" ">
    <header className="dark:border-gray-700 h-20 fixed w-full dark:bg-gray-800 py-5 shdow flex justify-around items-center">
        {/*room name */}
    <div>
        <h1 className="text-xl font-semibold">  
            Room: <span>Family room</span>
        </h1>
    </div>
    {/*username container*/}
    <div>
        <h1 className="text-xl font-semibold">  
            User Name: <span>Vaibhav Yeotikar</span>
        </h1>
    </div>
    {/*button: leave room */}
    <div>
        <button className="dark:bg-red-500 dark:hover:bg-red-600 px-3 py-2 rounded-full">
            Leave Room
        </button>
    </div>
    </header>
    <main className="py-20 px-10   w-2/3 dark:bg-slate-600 mx-auto h-screen overflow-auto ">
        {
            messages.map((messages,index)=>(
                <div
            key={index}
            className={`flex ${
              messages.sender === currentUser ? "justify-end" : "justify-start"
            } `}
          >
            <div
              className={`my-2 ${
                messages.sender === currentUser ? "bg-orange-700" : "bg-violet-900"
              } p-2 max-w-xs rounded`}
            >
              <div className="flex flex-row gap-2">
                <img
                  className="h-10 w-10"
                  src={"https://avatar.iran.liara.run/public/43"}
                  alt=""
                />
                <div className="flex flex-col gap-1">
                  <p className="text-sm font-bold">{messages.sender}</p>
                  <p>{messages.content}</p>
                </div>
              </div>
            </div>
          </div>
            ))
        }
    </main>
    

    {/* Input message container*/}
    <div className="fixed bottom-4 w-full h-16 ">
        <div className="h-full  pr-10 gap-4 flex items-center justify-between rounded-full w-1/2 mx-auto dark:bg-gray-800">
        <input
            type="text"
            placeholder="Type your message here..."
            className=" w-full  dark:border-gray-600 b dark:bg-gray-800  px-5 py-2 rounded-full h-full focus:outline-none  "
          />
           <button className="dark:bg-purple-600 h-10 w-10  flex   justify-center items-center rounded-full">
                <FaFileUpload size={20}/>
           </button>
           <button className="dark:bg-orange-600 h-10 w-10  flex justify-center items-center rounded-full">
                <IoSend size={20} />
           </button>
        </div>  
    </div>
    </div>
  );
};

export default ChatPage