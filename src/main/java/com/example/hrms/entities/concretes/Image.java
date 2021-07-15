package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int imageId;

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "public_id")
    private String publicId;

    @Column(name="status",columnDefinition="boolean default false",nullable = false)
    private boolean status;

    @OneToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;


    public Image(String name, String image_url, String public_id) {
        this.name = name;
        this.imageUrl = image_url;
        this.publicId= public_id;
    }


}
