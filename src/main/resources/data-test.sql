INSERT INTO categories (name, description, created_at, updated_at)
VALUES
    ('Technology', 'Category related to tech advancements and products.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Health', 'Category focused on health and wellness topics.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Education', 'Category that covers educational programs and platforms.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Finance', 'Category for financial advice and news.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)

    ON CONFLICT DO NOTHING;


INSERT INTO companies (company_name, website, description, country, email, phone, created_at, updated_at)
VALUES
    ('Tech Innovations', 'techinnovations', 'Leading tech company specialized in AI.', 'USA', 'contact@techinnovations.com', '1234567890', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Eco Solutions', 'ecosolutions', 'Green energy provider.', 'Germany', 'info@ecosolutions.com', '0987654321', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('HealthTech', 'healthtech', 'Healthcare software solutions.', 'UK', 'support@healthtech.com', '1122334455', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('EduPro', 'edupro', 'Educational platforms for schools.', 'Canada', 'contact@edupro.com', '6677889900', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)

    ON CONFLICT DO NOTHING;


INSERT INTO jobs (title, description, location, job_type, created_at, salary_range, company_id, category_id)
VALUES
    ('Software Engineer', 'Develop and maintain web applications.', 'San Francisco, CA', 'Full-time', CURRENT_TIMESTAMP, 120000, 1,1),
    ('Project Manager', 'Lead project teams to successful outcomes.', 'Berlin, Germany', 'Contract', CURRENT_TIMESTAMP, 90000, 2,1),
    ('Data Analyst', 'Analyze and interpret complex data sets.', 'Remote', 'Part-time', CURRENT_TIMESTAMP, 60000, 3,1),
    ('Marketing Specialist', 'Develop and execute marketing strategies.', 'New York, NY', 'Full-time', CURRENT_TIMESTAMP, 75000, 4,1)

    ON CONFLICT DO NOTHING;

INSERT INTO applicants (first_name, last_name, degree, description, country, college, email, phone, created_at, updated_at)
VALUES
    ('John', 'Doe', 'Computer Science', 'Experienced in backend development.', 'USA', 'MIT', 'johndoe@example.com', '1234567890', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Jane', 'Smith', 'Business Administration', 'Project manager with 5 years of experience.', 'Canada', 'University of Toronto', 'janesmith@example.com', '0987654321', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Alice', 'Johnson', 'Marketing', 'Specialist in digital marketing.', 'UK', 'London School of Economics', 'alicejohnson@example.com', '1122334455', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Bob', 'Brown', 'Law', 'Legal consultant with international experience.', 'Australia', 'University of Sydney', 'bobbrown@example.com', '6677889900', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)

    ON CONFLICT DO NOTHING;

