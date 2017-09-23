const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

const follow = require('./follow');

const root = '/api';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {characters: []};
    }

    loadFromServer(pageSize) {
        follow(client, root, [
            {rel: 'characters', params: {size: pageSize}}]
        ).then(characterCollection => {
            return client({
                method: 'GET',
                path: characterCollection.entity._links.profile.href,
                headers: {'Accept': 'application/schema+json'}
            }).then(schema => {
                this.schema = schema.entity;
                return characterCollection;
            });
        }).done(characterCollection => {
            this.setState({
                characters: characterCollection.entity._embedded.characters,
                attributes: Object.keys(this.schema.properties),
                pageSize: pageSize,
                links: characterCollection.entity._links});
        });
    }

    componentDidMount() {
        this.loadFromServer(this.state.pageSize);
    }

    render() {
        return (
            <CharacterList characters={this.state.characters}/>
        )
    }
}

class CharacterList extends React.Component{
    render() {
        var characters = this.props.characters.map(character =>
            <Character key={character._links.self.href} character={character}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Name</th>
                </tr>
                {characters}
                </tbody>
            </table>
        )
    }
}

class Character extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.character.name}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)