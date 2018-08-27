import React, { Component } from 'react'
// react-icons refused to load, was issue with NPM.
import FaPencil from 'react-icons/lib/fa/pencil'
import FaTrash from 'react-icons/lib/fa/trash'


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
