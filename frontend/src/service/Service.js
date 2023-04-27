import axios from '../axios/axios';

const Service = {
    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get("/categories")
    },

    fetchAuthors: () => {
        return axios.get("/authors")
    },

    addBook: (name, category, authorId, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        });
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`)
    },

    editBook: (id, name, category, authorId, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        });
    },

    reduceCopy: (id) => {
        return axios.post(`/books/reduceCopy/${id}`)
    }
}

export default Service;

