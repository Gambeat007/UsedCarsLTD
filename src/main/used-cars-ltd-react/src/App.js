import React, {useState, useEffect, Component} from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

// import AuthService from "./services/auth.service";
// import Login from "./components/Login";
// import Register from "./components/Register";
// import Home from "./components/Home";
// import Profile from "./components/Profile";
// import BoardUser from "./components/BoardPublic";
// import BoardCustomer from "./components/BoardCustomer";
// import BoardOwner from "./components/BoardOwner";
// import AuthVerify from "./common/AuthVerify";
// import EventBus from "./common/EventBus";

import AddVehicle from "./components/add-vehicle.component";

class App extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand navbar-dark bg-dark">
                    <Link to={"/vehicles"} className="navbar-brand"># Used Cars Ltd. #</Link>

                    <div className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <Link to={"/vehicles/add-new"} className="nav-link">Add car</Link>
                        </li>
                        {/* <li className="nav-item">
              <Link to={"/vehicles/by-make{make}"} className="nav-link">Find car by make</Link>
            </li>
            <li className="nav-item">
              <Link to={"/vehicles/by-model{model}"} className="nav-link">Find car by model</Link>
            </li>
            <li className="nav-item">
              <Link to={"/vehicles/by-production-year{prodYear}"} className="nav-link">Find car by production year</Link>
            </li>
            <li className="nav-item">
              <Link to={"/vehicles/by-fuel-type{fuelType}"} className="nav-link">Find car by fuel type</Link>
            </li> */}
                    </div>
                </nav>

                <div className="container mt-3">
                    <Routes>
                        <Route path="/vehicles/add-new" element={<AddVehicle/>} />
                        {/* <Route path="/vehicles/" element={<Vehicle/>} /> */}
                    </Routes>
                </div>
            </div>
        );
    }
}

export default App;

// const App = () => {
//     const [showCustomerBoard, setShowCustomerBoard] = useState(false);
//     const [showOwnerBoard, setShowOwnerBoard] = useState(false);
//     const [currentUser, setCurrentUser] = useState(undefined);
//
//     useEffect(() => {
//         const user = AuthService.getCurrentUser();
//
//         if (user) {
//             setCurrentUser(user);
//             setShowCustomerBoard(user.roles.includes("ROLE_CUSTOMER"));
//             setShowOwnerBoard(user.roles.includes("ROLE_OWNER"));
//         }
//
//         EventBus.on("logout", () => {
//             logOut();
//         });
//
//         return () => {
//             EventBus.remove("logout");
//         };
//     }, []);
//
//     const logOut = () => {
//         AuthService.logout();
//         setShowCustomerBoard(false);
//         setShowOwnerBoard(false);
//         setCurrentUser(undefined);
//     };
//
//     return (
//         <div>
//             <nav className="navbar navbar-expand navbar-dark bg-dark">
//                 <Link to={"/"} className="navbar-brand">
//                     # Used Cars Ltd #
//                 </Link>
//                 <div className="navbar-nav mr-auto">
//                     <li className="nav-item">
//                         <Link to={"/home"} className="nav-link">
//                             Home
//                         </Link>
//                     </li>
//
//                     {showCustomerBoard && (
//                         <li className="nav-item">
//                             <Link to={"/customer"} className="nav-link">
//                                 Customer Board
//                             </Link>
//                         </li>
//                     )}
//
//                     {showOwnerBoard && (
//                         <li className="nav-item">
//                             <Link to={"/owner"} className="nav-link">
//                                 Owner Board
//                             </Link>
//                         </li>
//                     )}
//
//                     {currentUser && (
//                         <li className="nav-item">
//                             <Link to={"/public"} className="nav-link">
//                                 Public
//                             </Link>
//                         </li>
//                     )}
//                 </div>
//
//                 {currentUser ? (
//                     <div className="navbar-nav ml-auto">
//                         <li className="nav-item">
//                             <Link to={"/profile"} className="nav-link">
//                                 {currentUser.username}
//                             </Link>
//                         </li>
//                         <li className="nav-item">
//                             <a href="/login" className="nav-link" onClick={logOut}>
//                                 LogOut
//                             </a>
//                         </li>
//                     </div>
//                 ) : (
//                     <div className="navbar-nav ml-auto">
//                         <li className="nav-item">
//                             <Link to={"/login"} className="nav-link">
//                                 Login
//                             </Link>
//                         </li>
//
//                         <li className="nav-item">
//                             <Link to={"/register"} className="nav-link">
//                                 Sign Up
//                             </Link>
//                         </li>
//                     </div>
//                 )}
//             </nav>
//
//             <div className="container mt-3">
//                 <Routes>
//                     <Route exact path={"/"} element={<Home />} />
//                     <Route exact path={"/home"} element={<Home />} />
//                     <Route exact path="/login" element={<Login />} />
//                     <Route exact path="/register" element={<Register />} />
//                     <Route exact path="/profile" element={<Profile />} />
//                     <Route path="/public" element={<BoardUser />} />
//                     <Route path="/customer" element={<BoardCustomer />} />
//                     <Route path="/owner" element={<BoardOwner />} />
//                 </Routes>
//             </div>
//
//             {/* <AuthVerify logOut={logOut}/> */}
//         </div>
//     );
// };
