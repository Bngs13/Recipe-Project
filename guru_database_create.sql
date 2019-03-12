create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB;
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB;
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB;
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB;
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id);
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id);
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id);
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id);
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id);
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id);create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) engine=InnoDB
create table note (id bigint not null auto_increment, recipe_notes longtext, recipe_id bigint, primary key (id)) engine=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer, description varchar(255), difficulity varchar(255), direction longtext, image longblob, prep_time integer, serving integer, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB
create table recipe_category (recipe_id bigint not null, category_id bigint not null, primary key (recipe_id, category_id)) engine=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table note add constraint FKaeln1ftj8676mm6e78iu7ibwq foreign key (recipe_id) references recipe (id)
alter table recipe add constraint FK3bbvayscsgeamsdciqdsi5h81 foreign key (notes_id) references note (id)
alter table recipe_category add constraint FKqsi87i8d4qqdehlv2eiwvpwb foreign key (category_id) references category (id)
alter table recipe_category add constraint FKcqlqnvfyarhieewfeayk3v25v foreign key (recipe_id) references recipe (id)