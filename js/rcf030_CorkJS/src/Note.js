import React, { Component } from 'react'
// react-icons refused to load, was issue with NPM.
import { FaPencil } from 'react-icons/fa'
import { FaTrash } from 'react-icons/fa'


class Note extends Component {
  render () {
    return (
      <div className='note'>
        <p>Note Body</p>
        <span>
          <button><FaPencil /></button>
          <button><FaTrash /></button>
        </span>
      </div>
    )
  }
}

export default Note
