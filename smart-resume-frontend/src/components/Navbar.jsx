import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../assets/logo.png';

const Navbar = () => {
  return (
    <nav className="bg-white shadow-md p-4 flex justify-between items-center">
      <Link to="/">
        <img src={logo} alt="Logo" className="h-10" />
      </Link>
      <div className="space-x-4">
        <Link to="/" className="hover:text-blue-600">Home</Link>
        <Link to="/about" className="hover:text-blue-600">About</Link>
        <Link to="/contact" className="hover:text-blue-600">Contact</Link>
        <Link to="/resume-builder" className="hover:text-blue-600">Resume Builder</Link>
      </div>
    </nav>
  );
};

export default Navbar;
