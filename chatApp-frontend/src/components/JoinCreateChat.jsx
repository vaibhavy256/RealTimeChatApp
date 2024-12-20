import React from "react";

const JoinCreateChat = () => {
    return (
    <div className="min-h-screen flex items-center justify-center">
        <div className="p-8 w-full flex flex-col gap-5 max-w-md rounded dark:bg-gray-900 shadow">
            <h1 className="text-2xl font-semibold text-center">
                Join Room /Create Room ..
            </h1>
            {/*Name div */}
            <div className="">
                <label htmlFor="name" className="block font-medium mb-2">
                    Your name
                </label>
                <input
                    type="text"
                    id="name"
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
                    type="text"
                    id="name"
                    className="w-full dark:bg-gray-600 px-4 py-2 border dark:border-gray-300 rounded-lg 
                    focus:outline-none focus:ring-2 focus:ring-blue-500" 
                />
            </div>
        </div>
    </div>
    );
}
export default JoinCreateChat;