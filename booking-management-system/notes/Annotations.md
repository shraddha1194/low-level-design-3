## Annotations

1. `@MappedSuperClass` - Parent of all entities
2. `@Id` - Primary Key
3. `GeneratedValue` - Auto-generate a value
4. `@CreatedDate / @LastModifiedDate` - Auto-generate timestamps
5. `@Entity` - Tells JPA that this class is table
6. `@Table` - Modify table metadata
7. `@OneToOne, @OneToMany, @ManyToOne, @ManyToMany` - Establish relationship between entities
8. `@Enumerated` - This field is an enum
9. `@ElementCollection` - This is a collection but is not an entity, meaning no foreign key required