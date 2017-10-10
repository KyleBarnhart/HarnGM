import { connect } from 'react-redux';
import { fetchCharacters, addCharacter, deleteCharacter } from '../actions';
import CharacterList from '../components/CharacterList';

const mapStateToProps = state => {
    return {
        characters: state.characters,
    }
};

const mapDispatchToProps = dispatch => {
    return {
        onAddCharacter: character => {
            dispatch(addCharacter(character))
        },
        onDeleteCharacter: character => {
            dispatch(deleteCharacter(character))
        }
    }
};

const CharacterListContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(CharacterList);

export default CharacterListContainer