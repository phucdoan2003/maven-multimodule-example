package sead.assignment2.template.internal.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TemplateRepository extends JpaRepository<Template, Long> {
}
