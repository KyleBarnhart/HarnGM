import React from 'react';
import PropTypes from 'prop-types';

const Character = ({ character }) => (
    <tr>
        <td>{character.name}</td>
        <td>{character.player.name}</td>
    </tr>
);

Character.propTypes = {
    character: PropTypes.object.isRequired
};

export default Character