import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import BookList from '../Book/BookList/BookList';
import CategoryList from "../Category/CategoryList";
import Service from '../../service/Service'
import Header from "../Header/Header";
import BookAdd from "../Book/BookAdd/BookAdd";
import BookEdit from "../Book/BookEdit/BookEdit";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div>
                        <Routes>
                            <Route path={"/books/add"}
                                   element={<BookAdd authors={this.state.authors} categories={this.state.categories}
                                                     onAddBook={this.addBook}/>}/>
                            <Route path={"/books/edit/:id"}
                                   element={<BookEdit authors={this.state.authors} categories={this.state.categories}
                                                      book={this.state.selectedBook}
                                                      onEditBook={this.editBook}/>}/>
                            <Route path={"/books"}
                                   element={<BookList books={this.state.books} onDelete={this.deleteBook}
                                                      onEdit={this.getBook} reduceCopy={this.reduceCopy}/>}/>
                            <Route path={"/categories"} element={<CategoryList categories={this.state.categories}/>}/>
                            <Route path={"/"} element={<BookList books={this.state.books}/>}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }


    componentDidMount() {
        this.fetchData()
    }


    fetchData = () => {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }


    loadBooks = () => {
        Service.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadCategories = () => {
        Service.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadAuthors = () => {
        Service.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    addBook = (name, category, authorId, availableCopies) => {
        Service.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    deleteBook = (id) => {
        Service.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        Service.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            });
    }

    editBook = (id, name, category, authorId, availableCopies) => {
        Service.editBook(id, name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks()
            });
    }

    reduceCopy = (id) => {
        Service.reduceCopy(id)
            .then(() => {
                this.loadBooks()
            });
    }


}

export default App;
