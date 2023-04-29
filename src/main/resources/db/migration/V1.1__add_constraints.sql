alter table public.CLIENTE
    add constraint FK_wertyuiqwsag12312fg FOREIGN KEY (`rol_id`) REFERENCES `ROL` (`id`);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;