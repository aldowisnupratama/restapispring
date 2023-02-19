package com.aldopratama.restapi.model

import jakarta.persistence.*


@Entity
@Table(name= "Employee")
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id:Long,
    @Column(name="first_name")
    var firstName: String,
    @Column(name="last_name")
    var lastName: String,
    @Column(name="email_id")
    var emailId : String

)
