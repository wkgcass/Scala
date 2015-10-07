package net.cassite.autoee.page.dom;

/**
 * @author wkgcass
 */
class input() extends SelfClose("input") {
  def typ(t: String) = update("type", t)
  def value(v: String) = update("value", v)
}

object input {

  object button {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("button", id, name, cls, value)
    }
  }

  object submit {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("submit", id, name, cls, value)
    }
  }

  object reset {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("reset", id, name, cls, value)
    }
  }

  object text {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("text", id, name, cls, value)
    }
  }

  object email {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("email", id, name, cls, value)
    }
  }

  object password {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("password", id, name, cls, value)
    }
  }

  object checkbox {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("checkbox", id, name, cls, value)
    }
  }

  object file {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("file", id, name, cls, value)
    }
  }

  object hidden {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("hidden", id, name, cls, value)
    }
  }

  object radio {
    def apply(id: String = null, name: String = null, cls: String = null, value: String = null) = {
      input("radio", id, name, cls, value)
    }
  }

  def apply(t: String = null, id: String = null, name: String = null, cls: String = null, value: String = null) = {
    val i = new input
    i typ t
    i id id
    i name name
    i cls cls
    i value value
    i
  }
}