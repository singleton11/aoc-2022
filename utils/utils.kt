fun readResourceAsText(path: String): String = object {}.javaClass.getResource(path)?.readText() ?: ""