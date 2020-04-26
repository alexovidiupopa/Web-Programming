<?php


class LogReport
{
    public $id;
    public $author_email;
    public $message;
    public $type;
    public $severity;
    public $posted_on;

    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @return mixed
     */
    public function getAuthorEmail()
    {
        return $this->author_email;
    }

    /**
     * @return mixed
     */
    public function getMessage()
    {
        return $this->message;
    }

    /**
     * @return mixed
     */
    public function getType()
    {
        return $this->type;
    }

    /**
     * @return mixed
     */
    public function getSeverity()
    {
        return $this->severity;
    }

    /**
     * @return mixed
     */
    public function getPostedOn()
    {
        return $this->posted_on;
    }

    /**
     * logreport constructor.
     * @param $id
     * @param $author_email
     * @param $message
     * @param $type
     * @param $severity
     * @param $posted_on
     */
    public function __construct($id, $author_email, $message, $type, $severity, $posted_on)
    {
        $this->id = $id;
        $this->author_email = $author_email;
        $this->message = $message;
        $this->type = $type;
        $this->severity = $severity;
        $this->posted_on = $posted_on;
    }

    /**
     * @param mixed $author_email
     */
    public function setAuthorEmail($author_email)
    {
        $this->author_email = $author_email;
    }

    /**
     * @param mixed $message
     */
    public function setMessage($message)
    {
        $this->message = $message;
    }

    /**
     * @param mixed $type
     */
    public function setType($type)
    {
        $this->type = $type;
    }

    /**
     * @param mixed $severity
     */
    public function setSeverity($severity)
    {
        $this->severity = $severity;
    }

    /**
     * @param mixed $posted_on
     */
    public function setPostedOn($posted_on)
    {
        $this->posted_on = $posted_on;
    }


}