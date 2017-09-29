import React from 'react';
import PropTypes from 'prop-types';
import Character from './Character';

const CharacterList = ({ characters }) => (
    <div>
        <table>
            <tbody>
            <tr>
                <th>Name</th>
                <th>Player Name</th>
            </tr>
            {characters.map(character => <Character character={character}/>)}
            </tbody>
        </table>
    </div>
);

CharacterList.propTypes = {
    characters: PropTypes.arrayOf(
        PropTypes.shape({
            character: PropTypes.object.isRequired
        }).isRequired
    ).isRequired
};

export default CharacterList