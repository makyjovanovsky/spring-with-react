import React from 'react';
import {Link} from 'react-router-dom';


const ProductTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name} {props.term.author.surname}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger ml-3"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-3"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
                <a title={"Mark as taken"} className={"btn btn-primary"}
                    onClick={() => props.reduceCopy(props.term.id)}>
                    Mark as taken
                </a>
            </td>
        </tr>
    )
}

export default ProductTerm;
