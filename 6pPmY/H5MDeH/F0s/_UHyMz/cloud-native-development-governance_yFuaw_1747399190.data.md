All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
### Fixed
- Problem with pip and cryptography and updated packages' versions

- Enable multi-line option for append load
  
## [5.7.3] - 2021-02
### Added
- Make init condensation optional, but true by default.
  
### Added
- Modify append load to support more complex partitioning strategies without file_regex
- Added support for configuring write load mode and num output files in append load

## [5.7.1] - 2020-01
### Added
- Parameter source_dir_suffix was added to enable us to read simultaneously from several nested "folders" inside data/. Ex: data/20200101/filename.parquet
- Support for multiple partition attributes (non date-derived) and single non date-derived partition attributes.