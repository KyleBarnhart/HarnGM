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
            {characters.map(character => <Character key={character.id} character={character}/>)}
            </tbody>
        </table>
    </div>
);

CharacterList.propTypes = {
    characters: PropTypes.array.isRequired
};

export default CharacterList