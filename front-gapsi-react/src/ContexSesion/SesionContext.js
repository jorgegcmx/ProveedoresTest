import React, { createContext, useState } from "react";

export const SesionContext = createContext();

export const SesionContextProvider = ({ children }) => {
    const [login, setLogin] = useState(false);


    return (
        <SesionContext.Provider value={{            
            login,
            setLogin,
        }}>
            {children}
        </SesionContext.Provider>
    )
}