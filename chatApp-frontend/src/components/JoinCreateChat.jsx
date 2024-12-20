import React, { useState } from "react";
import chatIcon from "../assets/speech-bubble.png"
import toast from "react-hot-toast";

const JoinCreateChat = () => {

    const[detail, setDetail]=useState({
        roomId:"",
        userName:""
    })
    function handleFormInputChange(event){
        setDetail({
            ...detail,
            [event.target.name]:event.target.value,
        });
    }

    function validateForm(){
            if(detail.userName==="" || detail.roomId===""){
                toast.error("Invalid input!")
                return false;
            }
            return true;
    }

    function joinChat(){
        if(validateForm()){
            console.log(detail);
        }

    }

    async function createRoom(){
        if(validateForm()){
            console.log(detail);
            try{
                const response=await createRoom(detail.roomId,detail.userName)
                console.log(response);
                toast.success("Room created successfully!!");
                joinChat();
            }
            catch (error){
                console.log(error);
                console.log("Error in creating room");
                
            }
        }
    }

    return (
    <div className="min-h-screen flex items-center justify-center">
        <div className="p-10 dark:border-gray-700 border w-full flex flex-col gap-5 max-w-md rounded dark:bg-gray-800 shadow">
            <div>
                <img src={chatIcon} className="w-24 mx-auto"/>
            </div>

            <h1 className="text-2xl font-semibold text-center">
                Join Room /Create Room ..
            </h1>
            {/*Name div */}
            <div className="">
                <label htmlFor="name" className="block font-medium mb-2">
                    Your name
                </label>
                <input
                    onChange={handleFormInputChange}
                    value={detail.userName}
                    type="text"
                    id="name"
                    name="userName"
                    placeholder="Enter the name.."
                    className="w-full dark:bg-gray-600 px-4 py-2 border dark:border-gray-300 rounded-lg 
                    focus:outline-none focus:ring-2 focus:ring-blue-500" 
                />
            </div>
            {/* room id div */}
            <div className="">
                <label htmlFor="name" className="block font-medium mb-2">
                    Room Id 
                </label>
                <input
                    name="roomId"
                    onChange={handleFormInputChange}
                    value={detail.roomId}
                    type="text"
                    id="name"
                    placeholder="Enter the room id"
                    className="w-full dark:bg-gray-600 px-4 py-2 border dark:border-gray-300 rounded-lg 
                    focus:outline-none focus:ring-2 focus:ring-blue-500" 
                />
            </div>

            {/*button */}
            <div className="flex justify-center gap-2">
                <button onClick={joinChat} className="px-3 py-2 dark:bg-blue-500 hover:dark:bg-blue-800 rounded-full">
                    Join Room 
                </button>
                <button onClick={createRoom} className="px-3 py-2 dark:bg-orange-500 hover:dark:bg-orange-800 rounded-full">
                    Create Room 
                </button>
            </div>
        </div>
    </div>
    );
}
export default JoinCreateChat;